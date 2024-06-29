<script setup lang="ts">
import { RouterLink, RouterView } from "vue-router";
import HelloWorld from "./components/HelloWorld.vue";
import { computed, onMounted } from "vue";
import { useAuth, useOidcStore } from "vue3-oidc";

const { signinRedirect, signoutRedirect, autoAuthenticate } = useAuth();

const { state } = useOidcStore();

const user = computed(() => state.value.user?.profile);

const signin = () => {
  signinRedirect();
  //The following operations are completed in the callback route
};

const signout = () => {
  signoutRedirect();
};

const popup = () => {
  state.value.userManager?.signinPopup();
};

/**
 * you can also use autoAuthenticate() to automatically authenticate the user,
 * or call open auth of createOidc options
 * current page into all pages will be automatically authenticated
 * 当前页面下的所有子页面都会自动认证
 */
onMounted(() => {
  autoAuthenticate();
});
</script>

<template>
  <header>
    <img
      alt="Vue logo"
      class="logo"
      src="@/assets/logo.svg"
      width="125"
      height="125"
    />

    <div class="wrapper">
      <HelloWorld msg="You did it!" />

      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
      </nav>
    </div>
  </header>

  <RouterView />
</template>

<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}
</style>
