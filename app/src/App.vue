<template>
  <div id="app" class="container">
    <div class="row sticky">
    <topbar v-if="page !== 'home'"></topbar>
    </div>
    <div class="container scrollable">
      <home v-if="page === 'home'" @play-click="handlePlayClick"></home>
      <roulette v-if="page === 'roulette'" v-on:question-selected="handleSelectedQuestion"></roulette>
      <question v-if="page === 'question'" v-bind:question="question" v-on:answer-submitted="handleSubmittedAnswer"></question>
      <answer v-if="page === 'answer'" v-bind:question="question" v-bind:answer="answer" @home-click="handleHomeClick" @continue-click="handleContinueClick"></answer>
    </div>
  </div>
 </template>

<style>
html {
  font-size: 100%;
}

.container {
  display: flex;
  flex-flow: column;
  background-color: #4CB9FF;
  height: 100vh;
}

.container > .scrollable {
  overflow-y: scroll;
}
</style>

<script>
import Topbar from './Topbar.vue'
import Home from './Home.vue'
import Roulette from './Roulette.vue'
import Question from './Question.vue'
import Answer from './Answer.vue'

export default {
  name: 'app',
  data: () => ({
    page: 'home'
  }),
  methods: {
    handlePlayClick: function () {
      this.page = 'roulette'
    },
    handleSelectedQuestion: function (question) {
      this.question = question
      this.page = 'question'
    },
    handleSubmittedAnswer: function (answer) {
      this.answer = answer
      this.page = 'answer'
    },
    handleHomeClick: function () {
      this.answer = this.question = undefined
      this.page = 'home'
    },
    handleContinueClick: function () {
      this.answer = this.question = undefined
      this.page = 'roulette'
    }
  },
  components: {
    Topbar,
    Home,
    Roulette,
    Question,
    Answer
  }
}
</script>
