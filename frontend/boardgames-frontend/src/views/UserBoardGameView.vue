<template>
  <UserBoardGame />
</template>

<script>
import { defineComponent } from "vue";

// Components
import UserBoardGame from "../components/UserBoardGame.vue";

export default defineComponent({
  name: "UserBoardGameView",

  components: {
    UserBoardGame,
  },
});
</script>
