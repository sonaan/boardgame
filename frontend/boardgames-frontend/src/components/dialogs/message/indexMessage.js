import axios from "axios";

export default {
  props: {
    mode: { type: String, default: "" },
    useridsend: { type: String, default: "" },
    useridreceive: { type: String, default: "" },
    userloginsend: { type: String, default: "" },
  },

  data() {
    return {
      url: "/message/new/",
      method: "post",
      data: JSON.stringify({}),
      dialogmessage: false,
      message: null,
    };
  },

  methods: {
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

    add() {
      this.data = JSON.stringify({
        useridSend: this.useridsend,
        useridReceive: this.useridreceive,
        message: this.message,
      });
      this.getDataFromApi().then(() => {
        this.message = "";
        this.$emit("close");
      });
    },

    close() {
      this.dialogmessage = false;
    },
  },
};
