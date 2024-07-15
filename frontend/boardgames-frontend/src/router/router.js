import { createRouter, createWebHistory } from "vue-router";
import BoardGamesView from "../views/BoardGamesView.vue";
import BoardGameView from "../views/BoardGameView.vue";
import UserBoardGameView from "../views/UserBoardGameView.vue";
import SellPageView from "../views/SellPageView.vue";
import BuyPageView from "../views/BuyPageView.vue";
import PurchaseOrderView from "../views/PurchaseOrderView.vue";
import MarketPageView from "../views/MarketPageView.vue";
import ExchangePageView from "../views/ExchangePageView.vue";
import ExchangeOrderView from "../views/ExchangeOrderView.vue";
import FriendPageView from "../views/FriendPageView.vue";
import MessagePageView from "../views/MessagePageView.vue";

const routes = [
  {
    path: "/",
    name: "games",
    component: BoardGamesView,
  },
  {
    path: "/game/:id",
    name: "game",
    props: true,
    component: BoardGameView,
  },
  {
    path: "/usergames/",
    name: "usergames",
    props: true,
    component: UserBoardGameView,
  },
  {
    path: "/sell/",
    name: "sell",
    component: SellPageView,
  },
  {
    path: "/buy/",
    name: "buy",
    component: BuyPageView,
  },
  {
    path: "/exchange/",
    name: "exchange",
    component: ExchangePageView,
  },
  {
    path: "/friend/",
    name: "friend",
    component: FriendPageView,
  },
  {
    path: "/message/",
    name: "message",
    component: MessagePageView,
  },
  {
    path: "/purchaseorder/:id",
    name: "purchaseorder",
    props: true,
    component: PurchaseOrderView,
  },
  {
    path: "/exchangeorder/:id",
    name: "exchangeorder",
    props: true,
    component: ExchangeOrderView,
  },
  {
    path: "/market/",
    name: "market",
    component: MarketPageView,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
