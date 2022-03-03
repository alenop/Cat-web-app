<script setup>
import Cat from "../components/Cat.vue";
</script>

<template>
  <div>
    <div class="containerImages">
      <div>
        <Cat
          v-on:update="changeImages()"
          :Src="left"
          :ID="IDLeftCat"
          CatName="namelessCat1"
        />
      </div>
      <div>
        <Cat
          v-on:update="changeImages()"
          :Src="right"
          :ID="IDRightCat"
          CatName="namelessCat2"
        />
      </div>
    </div>
    <button @click="changePage()">See the cutests cats !</button>
  </div>
</template>
<script>
import axios from "axios";
export default {
  methods: {
    changeImages() {
      axios
        .get("https://cutestcat.osc-fr1.scalingo.io/cat/Get")
        .then((response) => {
          this.left = response.data[0].value1;
          this.right = response.data[1].value1;
          this.IDLeftCat = response.data[0].value0;
          this.IDRightCat = response.data[1].value0;
        });
    },
    changePage() {
      this.$parent.$data.votePage = false;
    },
  },
  data() {
    return {
      right: "DefaultRight",
      left: "DefaultLeft",
      IDLeftCat: "",
      IDRightCat: "",
    };
  },
  mounted() {
    this.changeImages();
  },
};
</script>
<style scoped>
@import "../assets/style/PageVote.css";
</style>