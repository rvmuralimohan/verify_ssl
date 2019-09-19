def  totalNoDayss(date) { // This method will return no of days.
       
        long days = 0;

        try {
            if (date != 0) {
                int year = 0;
                int month = 0;
                int day = 0;
                String strDate = String.valueOf(date);

                if (strDate.length() == 4) {
                    strDate = "00" + strDate;
                }

                if (strDate.length() == 5) {
                    strDate = "0" + strDate;
                }

                if (strDate.length() == 8) {
                    year = Integer.parseInt(strDate.substring(0, 4));
                    month = Integer.parseInt(strDate.substring(4, 6));
                    day = Integer.parseInt(strDate.substring(6, 8));
                } else if (strDate.length() == 6) {
                    year = Integer.parseInt("19" + strDate.substring(0, 2));
                    month = Integer.parseInt(strDate.substring(2, 4));
                    day = Integer.parseInt(strDate.substring(4, 6));
                }

                GregorianCalendar firstDate = new GregorianCalendar(year, month - 1, day);
                GregorianCalendar baseDate = null;

                baseDate = new GregorianCalendar(1899, 12 - 1, 31);
                double millisBetween = firstDate.getTimeInMillis() - baseDate.getTimeInMillis();
                days = Math.round((millisBetween / (1000 * 60 * 60 * 24)));
            }
        } catch (Exception pe) {
            System.out.println("Exception :: " + pe.getMessage());
        }

        return days;
    } // End of this method.
