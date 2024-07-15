<template>
  <ExchangePage />
</template>

<script>
import { defineComponent } from "vue";

// Components
import ExchangePage from "../components/ExchangePage.vue";

export default defineComponent({
  name: "ExchangePageView",

  components: {
    ExchangePage,
  },
});
</script>
