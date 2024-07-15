<template>
  <BuyPage />
</template>

<script>
import { defineComponent } from "vue";

// Components
import BuyPage from "../components/BuyPage.vue";

export default defineComponent({
  name: "BuyPageView",

  components: {
    BuyPage,
  },
});
</script>
