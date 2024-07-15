<template>
  <FriendPage />
</template>

<script>
import { defineComponent } from "vue";

// Components
import FriendPage from "../components/FriendPage.vue";

export default defineComponent({
  name: "FriendPageView",

  components: {
    FriendPage,
  },
});
</script>
