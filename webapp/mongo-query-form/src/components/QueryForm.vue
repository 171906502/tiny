<template>
    <div>
      <form @submit.prevent="submitForm">
        <div v-for="(field, index) in fields" :key="index" class="field-row">
          <label :for="field.name">{{ field.label }}</label>
          <select v-model="field.operator" class="operator-select">
            <option value="$eq">=</option>
            <option value="$gt">></option>
            <!-- eslint-disable-next-line -->
            <option value="$lt"><</option>
            <option value="$ne">!=</option>
            <option value="$in">IN</option>
            <option value="$nin">NOT IN</option>
          </select>
          <input v-model="field.value" :type="field.type" class="field-input" />
        </div>
        <div>
          <label for="selectFields">Select Fields (comma separated)</label>
          <input v-model="selectFields" type="text" id="selectFields" class="field-input" />
        </div>
        <button type="submit">Submit</button>
      </form>
      <div v-if="results.length">
        <h3>Results</h3>
        <pre>{{ results }}</pre>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'QueryForm',
    props: {
      fields: {
        type: Array,
        required: true
      }
    },
    data() {
      return {
        query: {},
        selectFields: '',
        results: []
      };
    },
    methods: {
      generateQuery() {
        const query = {};
        this.fields.forEach(field => {
          if (!query[field.name]) {
            query[field.name] = {};
          }
          switch (field.operator) {
            case '$in':
            case '$nin':
              query[field.name][field.operator] = field.value.split(',').map(item => item.trim());
              break;
            default:
              query[field.name][field.operator] = field.value;
          }
        });
        this.query = query;
      },
      async submitForm() {
        this.generateQuery();
        const payload = {
          filter: this.query,
          select: this.selectFields.split(',').map(field => field.trim())
        };
        try {
          const response = await axios.post('/api/query', payload);
          this.results = response.data;
        } catch (error) {
          console.error('There was an error!', error);
        }
      }
    }
  };
  </script>
  
  <style>
  .field-row {
    margin-bottom: 10px;
  }
  
  .operator-select {
    margin-right: 10px;
  }
  
  .field-input {
    margin-right: 10px;
  }
  </style>
  