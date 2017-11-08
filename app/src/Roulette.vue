<template>
  <div class="row">
    <div class="col-md-12 roulette-container">
      <a href="#" v-on:click="throwRoulette">
        <img class="roulette frame visible" data-category=0 src="/assets/ruleta-a3.png">
        <img class="roulette frame" data-category=1 src="/assets/ruleta-a4.png">
        <img class="roulette frame" data-category=2 src="/assets/ruleta-a5.png">
        <img class="roulette frame" data-category=3 src="/assets/ruleta-a6.png">
        <img class="roulette frame" data-category=4 src="/assets/ruleta-a7.png">
        <img class="roulette frame" data-category=5 src="/assets/ruleta-a8.png">
      </a>
    </div>
    <div class="col-md-12 category-legend" v-if="categoryVisible">
      <div class="jumbotron centered">
        <h1>{{ category }}</h1>
      </div>
    </div>
  </div>
</template>

<script>
import config from './config'

const CATEGORIES = {
  0: 'Diversidad',
  1: 'Salud',
  2: 'Prevención',
  3: 'Proyecto',
  4: 'Derecho',
  5: 'Al azar'
}

export default {
  name: 'roulette',
  data: () => ({
    categoryVisible: false
  }),
  methods: {
    showCategory: function (categoryId) {
      this.category = CATEGORIES[categoryId]
      this.categoryVisible = true
    },
    getRandomCategory: function (min, max) {
      return Math.floor(Math.random() * (max + 1 - min) + min);
    },
    throwRoulette: function () {
      // No me enorgullezco de este código. Refactor needed.
      let currentCat = 0
      function nextFrame() {
        const activeEl = document.querySelector(".roulette.frame.visible")
        const currentIdx = +activeEl.dataset["category"]
        const nextIdx = currentIdx === 5 ? 0 : (+currentIdx + 1)
        const nextEl = document.querySelector(`.roulette.frame[data-category="${nextIdx}"]`)
        nextEl.classList.add("visible")
        activeEl.classList.remove("visible")
        currentCat = nextIdx
      }

      let speed = 100
      const category = this.getRandomCategory(0, 5)
      let count = 0

      const i1 = setInterval(nextFrame, 50)
      setTimeout(() => {
        clearInterval(i1)
        const i2 = setInterval(nextFrame, 100)
        setTimeout(() => {
          clearInterval(i2)
          const i3 = setInterval(nextFrame, 500)
          setTimeout(() => {
            clearInterval(i3)
            const i4 = setInterval(() => {
              if (currentCat === category) {
                clearInterval(i4)
                this.showCategory(category)
                setTimeout(() => this.getQuestion(category), 1000)
              } else {
                nextFrame()
              }
            }, 600)
          }, 1000)
        }, 1000)
      }, 1000)
    },
    getQuestion: function (category) {
      let url = `${config.host}/preguntas`
      if (category !== 5) { // Si la categoría es Al azar, no se le envía categoría al backend
        url += `?categoria=${category}`
      }

      fetch(url)
        .then(res => res.json())
        .then(question => {
          this.$emit('question-selected', question)
        })
    }
  }
}
</script>

