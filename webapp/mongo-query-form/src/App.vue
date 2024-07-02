<template>
  <div id="app">
    <QueryForm :fields="fields" />
  </div>
</template>

<script>
import QueryForm from './components/QueryForm.vue';

export default {
  name: 'App',
  components: {
    QueryForm
  },
  data() {
    return {
      fields: [
        { name: 'age', label: 'Age', type: 'number', operator: '$eq', value: '' },
        { name: 'name', label: 'Name', type: 'text', operator: '$eq', value: '' },
        { name: 'status', label: 'Status', type: 'text', operator: '$eq', value: '' }
      ]
    };
  }
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
