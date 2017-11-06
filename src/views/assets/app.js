(function () {
  const CATEGORIES = {
    0: 'Diversidad',
    1: 'Salud',
    2: 'Prevención',
    3: 'Proyecto',
    4: 'Derecho',
    5: 'Al azar'
  }

  const app = new Vue({
    el: '#app',
    data: {
      host: 'http://cresi.herokuapp.com',
      page: 'home',
      categoryVisible: false,
      category: ''
    },
    methods: {
      goQuestion: function () {
        this.page = 'question'
      },
      goAnswer: function () {
        this.page = 'answer'
      },
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
        let url = `${this.host}/preguntas`
        if (category !== 5) { // Si la categoría es Al azar, no se le envía categoría al backend
          url += `?categoria=${category}`
        }

        fetch(url)
          .then(res => res.json())
          .then(question => {
            this.question = question
            this.goQuestion()
          })
      },
      submitAnswer: function (ev) {
        const answerId = ev.target.dataset["id"]
        fetch(`${this.host}/respuestas?pregunta_id=${this.question.id}&respuesta_id=${answerId}`)
          .then(res => res.json())
          .then(answer => {
            this.answer = answer
            this.goAnswer()
          })
      },
      goHome: function (ev) {
        this.page = "home"
      },
      goRoulette: function (ev) {
        this.categoryVisible = false
        this.category = ''
        this.page = "roulette";
      }
    }
  })
}())
