import axios from "axios";
import { mapActions } from "vuex";

export default {
  data() {
    return {
      url: "",
      method: "get",
      data: JSON.stringify({}),
      dialog: false,
      email: "",
      password: "",
      error: false,
    };
  },

  computed: {
    error() {
      return this.$store.getters.error;
    },
  },

  methods: {
    ...mapActions([
      "loadUserDataFromServer",
      "setUser",
      "setFlagLogin",
      "setToken",
      "setFlagAdmin",
    ]),

    getDataFromApi() {
      var config;
      if (this.$store.getters.token == null) {
        config = {
          method: this.method,
          url: this.url,
          headers: {
            "Content-Type": "application/json",
          },
          data: this.data,
        };
      } else {
        config = {
          method: this.method,
          url: this.url,
          headers: {
            Authorization: `Bearer ${this.$store.getters.token}`,
            Accept: "application/json",
            "Content-Type": "application/json",
          },
          data: this.data,
        };
      }

      return axios(config);
    },

    onSignin() {
      this.method = "post";
      this.url = "/user/authenticate";
      this.data = JSON.stringify({
        email: this.email,
        password: this.password,
      });
      this.getDataFromApi().then((data) => {
        if (data.data == "") {
          this.error = true;
          return;
        } else {
          this.error = false;
          this.dialog = false;
          this.setToken(data.data.token);
          this.method = "get";
          this.url = "/user/finduser/" + this.email;
          this.data = JSON.stringify({});
          this.getDataFromApi().then((data) => {
            this.email = null;
            this.password = null;
            this.setUser(data.data);
            this.setFlagLogin(true);
            if (data.data.role == "ADMIN") {
              this.setFlagAdmin(true);
            } else {
              this.setFlagAdmin(false);
            }
            this.loadUserDataFromServer(data.data.id);
          });
        }
      });
    },

    close() {
      this.error = false;
      this.email = null;
      this.password = null;
      this.dialog = false;
    },

    onDismissed() {
      console.log("Dismissed Alert");
      this.error = false;
    },
  },
};
