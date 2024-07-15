import { createApp } from "vue";
import App from "./App.vue";
import router from "./router/router.js";
import store from "./store/store.js";
import vuetify from "./plugins/vuetify";
import { loadFonts } from "./plugins/webfontloader";
import { Icon } from "@iconify/vue";
import { createVuetify } from "vuetify";
import AlertCmp from "@/components/shared/AlertComponent.vue";

const myCustomLightTheme = {
  dark: false,
  colors: {
    background: "#FFFFFF",
    surface: "#FFFFFF",
    primary: "#6200EE",
    "primary-darken-1": "#3700B3",
    secondary: "#03DAC6",
    "secondary-darken-1": "#018786",
    error: "#B00020",
    info: "#2196F3",
    success: "#4CAF50",
    warning: "#FB8C00",
    olive: "#9ACD32",
  },
};

loadFonts();

const app = createApp(App).use(router).use(store).use(Icon).use(vuetify);

app.component("app-alert", AlertCmp);

app.mount("#app");

export default createVuetify({
  theme: {
    defaultTheme: "myCustomLightTheme",
    themes: {
      myCustomLightTheme,
    },
  },
});
