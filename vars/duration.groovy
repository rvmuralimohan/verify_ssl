class Example {

    public static void main(String[] args) {
        def lastWeek = new Date() - 7;
        def today = new Date()

        println daysBetween(lastWeek, today)
    }

    static def daysBetween(long expiryDateStr, long newday) {
        use(groovy.time.TimeCategory) {
           // def duration = expiryDateStr - newday
           long  duration = expiryDateStr - newday
            return duration.days
        }
    }
}
