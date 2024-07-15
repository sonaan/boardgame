<template>
  <ExchangeOrder />
</template>

<script>
import { defineComponent } from "vue";

// Components
import ExchangeOrder from "../components/ExchangeOrder.vue";

export default defineComponent({
  name: "ExchangeOrderView",

  components: {
    ExchangeOrder,
  },
});
</script>
