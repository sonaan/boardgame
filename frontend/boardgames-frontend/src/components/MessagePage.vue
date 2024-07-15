<template>
  <v-container>
    <v-row dense>
      <v-col cols="12">
        <v-tabs v-model="tab" color="deep-purple-accent-4" align-tabs="center">
          <v-tab value="1">Входящие</v-tab>
          <v-tab value="2">Отправленные</v-tab>
        </v-tabs>
        <v-window v-model="tab">
          <v-window-item value="1" key="1">
            <v-container fluid>
              <v-row>
                <v-col cols="12">
                  <DialogMessage
                    ref="dialogMessage"
                    :useridsend="this.user.id"
                    :useridreceive="useridreceive"
                    :userloginsend="userloginreceive"
                    @close="closeMessage()"
                  />
                </v-col>
                <v-col cols="12">
                  <v-card
                    class="elevation-10 mb-3"
                    v-for="message in messageinbox"
                    :key="message.id"
                    width="400px"
                    min-height="100px"
                    color="#9ACD32"
                  >
                    <div class="d-flex flex-no-wrap justify-space-between">
                      <v-card-text>
                        <v-col cols="12">
                          <v-row>
                            <v-col cols="7">
                              <p class="font-weight-regular">
                                <b> От кого: </b>
                                {{ message.loginSend }}
                              </p>
                            </v-col>
                            <v-col cols="5">
                              <v-btn
                                color="#9ACD32"
                                icon="mdi-email"
                                size="x-small"
                                class="float-md-end"
                                @click="openMessage(message)"
                              ></v-btn>
                            </v-col>
                          </v-row>
                        </v-col>
                        <v-col cols="12">
                          <p class="font-weight-regular">
                            <b> Сообщение: </b> {{ message.message }}
                          </p>
                        </v-col>
                      </v-card-text>
                    </div>
                  </v-card>
                </v-col>
              </v-row>
            </v-container>
          </v-window-item>
          <v-window-item value="2" key="2">
            <v-container fluid>
              <v-row>
                <v-col cols="12">
                  <v-card
                    class="elevation-10 mb-3"
                    v-for="message in messageoutbox"
                    :key="message.id"
                    width="400px"
                    min-height="100px"
                    color="#9ACD32"
                  >
                    <div class="d-flex flex-no-wrap justify-space-between">
                      <v-card-text>
                        <v-col cols="12">
                          <v-row>
                            <v-col cols="7">
                              <p class="font-weight-regular">
                                <b> Кому: </b>
                                {{ message.loginReceive }}
                              </p>
                            </v-col>
                            <v-col cols="5">
                              <v-btn
                                color="#9ACD32"
                                icon="mdi-email"
                                size="x-small"
                                class="float-md-end"
                                @click="openMessageOut(message)"
                              ></v-btn>
                            </v-col>
                          </v-row>
                        </v-col>
                        <v-col cols="12">
                          <p class="font-weight-regular">
                            <b> Сообщение: </b> {{ message.message }}
                          </p>
                        </v-col>
                      </v-card-text>
                    </div>
                  </v-card>
                </v-col>
              </v-row>
            </v-container>
          </v-window-item>
        </v-window>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
import DialogMessage from "@/components/dialogs/message/indexMessage.vue";
import { mapActions } from "vuex";

export default {
  name: "MessagePage",

  components: {
    DialogMessage,
  },

  data() {
    return {
      tab: null,
      dialogmessage: false,
      useridreceive: "",
      userloginreceive: "",
    };
  },

  computed: {
    messageinbox() {
      return this.$store.getters.listmessageinbox;
    },
    messageoutbox() {
      return this.$store.getters.listmessageoutbox;
    },
    user() {
      return this.$store.getters.user;
    },
  },

  methods: {
    ...mapActions(["loadMessageInbox", "loadMessageOutbox"]),
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

    openMessage(user) {
      this.useridreceive = user.useridSend;
      this.userloginreceive = user.loginSend;
      this.$refs.dialogMessage.dialogmessage = true;
    },
    openMessageOut(user) {
      this.useridreceive = user.useridReceive;
      this.userloginreceive = user.loginReceive;
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
