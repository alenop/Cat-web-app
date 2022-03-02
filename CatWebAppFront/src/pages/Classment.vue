<script setup>
import CatClassment from "../components/CatForClassment.vue"
</script>
<template>
<header  >
  <div class="containerClassment">
    <button @click="changePage()">GoToVote !</button>
    
    <CatClassment v-for="item in cats" :key="item" :Src="item.value1" :NbVote="item.value0"/>
    </div>
  </header>    
</template>
<style scoped>
@import "../assets/style/PageClassment.css";
</style>
<script>
import axios from "axios";
export default {
  methods:{
    getClassment(){
      axios.get("https://cutestcat.osc-fr1.scalingo.io/cat/GetAll").then((response) => {
          this.cats=response.data;
      })
    },
    changePage(){
      this.$parent.$data.votePage=true
    }
  },
  data(){
      return {
      cats:[],
      }
  },
  mounted(){
      this.getClassment();
  }
}
</script>