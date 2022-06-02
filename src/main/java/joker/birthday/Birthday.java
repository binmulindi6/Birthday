/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package joker.birthday;

import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author binmulindi6
 */
public class Birthday {
    
    private final SimpleDateFormat sdfComplet = new SimpleDateFormat("dd-MM-yyyy");
    private final SimpleDateFormat sdfY = new SimpleDateFormat("yyyy");
    private final SimpleDateFormat sdfM = new SimpleDateFormat("MM");
    private final SimpleDateFormat sdfD = new SimpleDateFormat("dd");
    private  Date tDate,bDate;
    private int Years,Months,Days;
    private int tYear,bYear,tMonth,bMonth,tDay,bDay;
    
    
    //public Birthday(){}
    public Birthday(String birthdayDate) throws ParseException{
        this.tDate = new Date();
        try{
            this.bDate = sdfComplet.parse(birthdayDate.trim());
            // Get Years
            this.tYear = parseInt(sdfY.format(tDate));
            this.bYear = parseInt(sdfY.format(bDate));

            //Get Months
            this.tMonth = parseInt(sdfM.format(tDate));
            this.bMonth = parseInt(sdfM.format(bDate));

            //Days
            this.tDay = parseInt(sdfD.format(tDate));
            this.bDay = parseInt(sdfD.format(bDate));
        } catch(ParseException e) {
            System.out.println("ERROR BRO");
        }
        
    }
    
    public String getBirthday(){
        checkVars();
        String birthday = "You have exactely: " + this.Days +" Days, " + this.Months + " Months and " + this.Years + " Years";
        return birthday;
    }
    
    public void checkVars(){
        if(this.tDay < this.bDay){
            this.tMonth -= 1;
            this.tDay += 30;
            this.Days = this.tDay - this.bDay;
            if(this.tMonth < this.bMonth){
                this.tYear -= 1;
                this.tMonth += 12;
                this.Months = this.tMonth - this.bMonth;
                this.Years = this.tYear - this.bYear;
            }else{
                this.Months = this.tMonth - this.bMonth;
                this.Years = this.tYear - this.bYear;
            }
        } else {
            if(this.tMonth < this.bMonth){
                this.tYear -= 1;
                this.tMonth += 12;
                this.Days = this.tDay - this.bDay;
                this.Months = this.tMonth - this.bMonth;
                this.Years = this.tYear - this.bYear;
            } else {
                this.Days = this.tDay - this.bDay;
                this.Months = this.tMonth - this.bMonth;
                this.Years = this.tYear - this.bYear;
            }
            
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
