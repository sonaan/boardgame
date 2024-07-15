<template>
  <MessagePage />
</template>

<script>
import { defineComponent } from "vue";

// Components
import MessagePage from "../components/MessagePage.vue";

export default defineComponent({
  name: "MessagePageView",

  components: {
    MessagePage,
  },
});
</script>
