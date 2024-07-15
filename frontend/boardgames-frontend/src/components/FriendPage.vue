<template>
  <v-container>
    <v-row dense>
      <v-col cols="12">
        <v-col>
          <p class="text-h5">
            <b> Друзья </b>
          </p>
        </v-col>
        <v-col cols="12">
          <DialogFriend
            ref="dialogFriend"
            class="float-md-start"
            @click="openSearch()"
            @close="refreshDate()"
          />
        </v-col>
        <v-col cols="12">
          <DialogMessage
            ref="dialogMessage"
            :useridsend="this.user.id"
            :useridreceive="useridreceive"
            :userloginsend="userloginreceive"
            @close="closeMessage()"
          />
        </v-col>
        <v-col cols="12"></v-col>

        <v-col cols="12" lg="2">
          <v-list-item
            v-for="friend in listfriend"
            :key="friend.userid"
            :title="friend.login"
          >
            <template v-slot:append>
              <v-btn
                color="#9ACD32"
                icon="mdi-email"
                @click="openMessage(friend)"
              ></v-btn>
            </template>
          </v-list-item>
        </v-col>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
import DialogFriend from "@/components/dialogs/friend/indexFriend.vue";
import DialogMessage from "@/components/dialogs/message/indexMessage.vue";
import { mapActions } from "vuex";

export default {
  name: "FriendPage",

  components: {
    DialogFriend,
    DialogMessage,
  },

  data() {
    return {
      url: "/friend/",
      method: "get",
      data: JSON.stringify({}),
      dialog: false,
      dialogmessage: false,
      useridreceive: "",
      userloginreceive: "",
    };
  },

  computed: {
    listfriend() {
      return this.$store.getters.listfriendget;
    },
    user() {
      return this.$store.getters.user;
    },
  },

  methods: {
    ...mapActions(["loadFriend", "loadMessageInbox", "loadMessageOutbox"]),
    getDataFromApi() {
      var config = {
        method: this.method,
        url: this.url,
        headers: {
          Authorization: `Bearer ${this.$store.getters.token}`,
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        data: this.data,
      };

      return axios(config);
    },
    openSearch() {
      this.$refs.dialogFriend.dialog = true;
    },
    refreshDate() {
      this.$refs.dialogFriend.dialog = false;
      this.loadFriend(this.user.id);
    },
    openMessage(friend) {
      this.useridreceive = friend.userid;
      this.userloginreceive = friend.login;
      this.$refs.dialogMessage.dialogmessage = true;
    },
    closeMessage() {
      this.$refs.dialogMessage.dialogmessage = false;
      this.loadMessageInbox(this.user.id);
      this.loadMessageOutbox(this.user.id);
    },
  },
};
</script>
