def call(Date startDate, Date endDate) {
  use(groovy.time.TimeCategory) {
    def duration = endDate - startDate
    return duration.days
  }
}
