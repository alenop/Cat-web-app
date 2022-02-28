<script setup>
import HelloWorld from "./components/HelloWorld.vue";
import TheWelcome from "./components/TheWelcome.vue";
import Cat from "./components/Cat.vue"
</script>

<template>
  <header>
  <div class="containerImages">
    <div class="left">
      <Cat v-on:update="changeImages()" CatName="namelessCat1" :Src="left" :ID="IDLeftCat"/>
    </div>
    <div class="right">
      <Cat v-on:update="changeImages()" CatName="namelessCat2" :Src="right" :ID="IDRightCat" />
    </div>
  </div>
  </header>
</template>
<script>
import axios from "axios";
export default {
  methods:{
    changeImages(){
      axios.get("http://localhost:8080/cat/Get").then((response) => {
      this.left=response.data[0].value1;
      this.right=response.data[1].value1;
      this.IDLeftCat=response.data[0].value0;
      this.IDRightCat=response.data[1].value0;
      })
    }
  },
  setup() {
    this.brave="strong"
  },
  data() {
    return {
      right:"DefaultRight",
      left:"DefaultLeft",

    }
  },
  mounted() {
    this.changeImages();
  }
}
</script>

<style>
@import "./assets/base.css";
@import "./assets/style/PageVote.css";

#app {
  max-width: 1280px;
  margin: 0 auto;
  padding: 2rem;

  font-weight: normal;
}

header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

a,
.green {
  text-decoration: none;
  color: hsla(160, 100%, 37%, 1);
  transition: 0.4s;
}

@media (hover: hover) {
  a:hover {
    background-color: hsla(160, 100%, 37%, 0.2);
  }
}

@media (min-width: 1024px) {
  body {
    display: flex;
    place-items: center;
  }

  #app {
    display: grid;
    grid-template-columns: 1fr 1fr;
    padding: 0 2rem;
  }

  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  .logo {
    margin: 0 2rem 0 0;
  }
}
</style>
