package project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import org.joda.time.DateTime;
import org.joda.time.Days;



///The GeoCountDownTimer class.
	public class GeoCountDownTimer {
		///instance variables. 
		private int month;
		private int year;
		protected int day;
		protected String fromDate;
		
		///A default private constructor.
		private GeoCountDownTimer() {
			month=0;
			year=0;
			day=0;
			
		}	
		
		///Allows for a 3 integer pass in for month, day, and then year.
		public GeoCountDownTimer(int month, int day, int year) {
			if(month<1 || month>12){
				throw new IllegalArgumentException();
			}
			if(day<1 || day>31){
				throw new IllegalArgumentException();
			}
			if(year<1){
				throw new IllegalArgumentException();
			}
			this.month=month;
			this.year=year;
			this.day=day;
			
			
		}
		///Sets other GeoCountDownTimer to this one. 
		public void GeoCountDownTimer(GeoCountDownTimer other) {
			if(other==null){
				throw new IllegalArgumentException();
			}
			
			this.month=other.month;
			this.day=other.day;
			this.year=other.year;
						
		}
		///A method that parses a date string into integer values for month, day, and year.
		public GeoCountDownTimer(String geoDate){
			if(geoDate.equals("")){
				throw new IllegalArgumentException();
			}
			if (Pattern.matches("[a-zA-Z]+", geoDate)){
				throw new IllegalArgumentException();
			}
			
			
			
			String str=geoDate;
			int x=0;
			int slash=0;
			String mo="";
			String da="";
			String yr="";
			
			///i counts to find the slashes 
				for (int i=0; i<geoDate.length()-1; i++){
					///when slashes are found the values before, after, and between are stored accordingly.
					if(geoDate.charAt(i)=='/'){
						slash++;
						if(slash==1){
							mo=geoDate.substring(x,i);
							x=i+1;	
						}
						if(slash==2){
							da=geoDate.substring(x,i);
							yr=geoDate.substring(i+1,geoDate.length());	
						}
						
						
					} 
					
				}	
				///stores parsed strings as integers in day, month, year.
				this.month=Integer.parseInt(mo);
				this.day=Integer.parseInt(da);
				this.year=Integer.parseInt(yr);
			
			
		}
		
		 @Override
		 ///generated hashCode
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + day;
			result = prime * result + month;
			result = prime * result + year;
			return result;
		}

		@Override
		///Checks to see if two objects are equal.
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GeoCountDownTimer other = (GeoCountDownTimer) obj;
			if (this.day != other.day)
				return false;
			if (this.month != other.month)
				return false;
			if (this.year != other.year)
				return false;
			return true;
			
		}
		///Compares two different input dates.
		 public int compareTo(GeoCountDownTimer other){
			 ///checks if dates are the same.
			 if(this.equals(other))
				 return 0;
			 ///compares years
			 if(this.year < other.year)	
				 return -1;
			 else if (this.year > other.year)
				 return 1;
			 else if(this.year == other.year){
				 ///compares months
				 if (this.month < other.month)
					 return -1;
				 else if(this.month > other.month)
					 return 1;
				 else if(this.month == other.month){
					 ///compares days
					 if (this.day < other.day)
						 return -1;
					 else if(this.day > other.day)
						 return 1;
			
					 
				 }
			 }
			 return 0;
		 }
		 ///Decreases days by the given value.
		 public void dec(int days){
			 for(int i=days; i>0; i--){
				 dec();
			 
			 }
			 
		 }
		 ///Subtracts one day from the current date.
		 public void dec(){
			 if(this.month==1 || this.month==2 || this.month==5 || this.month==7 || this.month==8 || this.month==10 || this.month==12){
				 if(this.day==1){
					 if(this.month==1){
						 this.month=12;
						 this.day=31;
						 this.year--;
					 }
					 else if(this.month==8 || this.month==2){
						 this.month--;
						 this.day=31;
					 }
					 else{
						 this.day=30;
						 this.month--;
					 }
				 }
				  else{
						if(this.day>1){
						this.day--;
						 }
						 
					 }
			 }	
			 else if(this.month==4 || this.month==6 || this.month==9 || this.month==11){
				 if(this.day==1){
						 this.day=31;
						 this.month--;
					 }
				 
			 	else{
					if(this.day>1){
					this.day--;
					 }
				 }
		 	}
			 
			 else if(this.month==3){
				if(this.year%4!=0){
					if(this.day==1){
						 this.day=28;
						 this.month--;
					 
					}else{
						if(this.day>1){
							this.day--;
						}
					}
				}
				else{
					if(this.day==1){
						 this.day=29;
						 this.month--;
					 
					}
					else{
						if(this.day>1){
							this.day--;
						}
					}
				}
			 }
				
				
			 
			 
		 }
		 ///increases days by the given value.
		 public void inc(int days){
			 for(int i=days; i>0; i--){
				 inc();
			 
			 }
			 
			 
			 
			 
		 }
		 ///Adds 1 day to date.
		 public void inc(){
			 if(this.month==1 || this.month==3 || this.month==5 || this.month==7 || this.month==8 || this.month==10 || this.month==12){
				 if(this.day==31){
					 if(this.month==12){
						 this.month=1;
						 this.day=1;
						 this.year++;
					 }
					 else{
						 this.day=1;
						 this.month++;
					 }
				 }
					 else{
							if(this.day<31){
							this.day++;
						 }
						 
					 }
			 }	
			 else if(this.month==4 || this.month==6 || this.month==9 || this.month==11){
				 if(this.day==30){
						 this.day=1;
						 this.month++;
					 }
				 
			 	else{
					if(this.day<30){
					this.day++;
					 }
				 }
		 	}
			 
			 else if(this.month==2){
				if(this.year%4!=0){
					if(this.day==28){
						 this.day=1;
						 this.month++;
					 
					}else{
						if(this.day<28){
							this.day++;
						}
					}
				}else{
					if(this.day==29){
						 this.day=1;
						 this.month++;
					 
					}else{
						if(this.day<29){
							this.day++;
						}
					}
				}
				
			 }
		 }
			 
			
		 
		 ///A method that turns the given date into a formatted date with the month as a name.
		 public String toString(){
			 String strMo = "";
			 String Date;
			 if(this.month == 1)
				 strMo="January";
			 else if(this.month == 2)
				 strMo="February";
			 else if(this.month == 3)
				 strMo="March";
			 else if(this.month == 4)
				 strMo="April";
			 else if(this.month == 5)
				 strMo="May";
			 else if(this.month == 6)
				 strMo="June";
			 else if(this.month == 7)
				 strMo="July";
			 else if(this.month == 8)
				 strMo="August";
			 else if(this.month == 9)
				 strMo="September";
			 else if(this.month == 10)
				 strMo="October";
			 else if(this.month == 11)
				 strMo="November";
			 else if(this.month == 12)
				 strMo="December";	
			Date=strMo + " " + this.day +", " + this.year;
			return Date;
			
				 
				 
		 }
		 
		 ///turns the date integer values into one string of the date.
		 public String toDateString(){
			 String str;
			 str=(this.month + "/" + this.day + "/" + this.year);
			 return str;
			 
		 }
		 
		 public void save(String fileName){
		 
				if(fileName != " "){
					PrintWriter out = null;
					try {
						out = new PrintWriter(new BufferedWriter(new FileWriter
								(fileName)));
					} 
					catch (IOException e) {
						e.printStackTrace();
					}

					// is saved in string format, invokes toString
					String s = this.month + "/" + this.day + "/" + this.year;
					out.print(s);
					System.out.println(s.toString());
					out.close(); 
				}
				else{
					throw new IllegalArgumentException("fileName is null");
				}
			}
		 
		 public void load (String fileName){
				
				//initializes instance variables of string
				String str = "";
				
						
				try{
						// open the data file
						Scanner fileReader = new Scanner(new File(fileName)); 
						
						BufferedReader lineReader = new BufferedReader
								(new FileReader(fileName));
						
						//Reads the line as a string from saved file
						lineReader.readLine();
						
						// set variables to equal next Strings to timer
						
						str = lineReader.readLine();
						
						// sets string str to Timer values
						str = (this.month + "/" + this.day + "/" 
						+ this.year);
						
						// invokes toString method and prints on a line
						System.out.println(str.toString());
				}

					// could not find file
				catch(FileNotFoundException error) {
					System.out.println("File not found ");
				}

				// problem reading the file
				catch(IOException error){
					System.out.println("Oops!  Something went wrong.");
				}
		}

		 
		 public int daysToGo(String fromDate){			 
				
				String str=fromDate;
				int x=0;
				int slash=0;
				String mo="";
				String da="";
				String yr="";
				
				int month = 0;
				int day = 0;
				int year = 0;
				
				///i counts to find the slashes 
					for (int i=0; i<fromDate.length()-1; i++){
						///when slashes are found the values before, after, and between are stored accordingly.
						if(fromDate.charAt(i)=='/'){
							slash++;
							if(slash==1){
								mo=fromDate.substring(x,i);
								x=i+1;	
							}
							if(slash==2){
								da=fromDate.substring(x,i);
								yr=fromDate.substring(i+1,fromDate.length());	
							}
							
							
						} 
						
					}	
					///stores parsed strings as integers in day, month, year.
					month=Integer.parseInt(mo);
					day=Integer.parseInt(da);
					year=Integer.parseInt(yr);
			 
			 DateTime dt1 = new DateTime(this.year, this.month, this.day, 0, 0, 0, 0);
			 DateTime dt2 = new DateTime(year, month, day, 0, 0, 0, 0);
			 int totalDays = Days.daysBetween(dt1, dt2).getDays();
			 System.out.println(totalDays);
			 			 
			 return (totalDays);
			 			 
			 
		 }
		 
		 
		 
		 public static void main(String args[]){
             ///Test geoDate string
			 GeoCountDownTimer geo = new GeoCountDownTimer("09/12/2016");
			 GeoCountDownTimer geo1 = new GeoCountDownTimer(6,6,2016);
			 
			 System.out.println(geo1);

			 
		     ///Test the basic GeoCountDownTimer input method
			 System.out.println("Month: " + geo.month);
			 System.out.println("Day: " + geo.day);
			 System.out.println("Year: " + geo.year);
			 
			 ///Test the compareTo method
			 System.out.println(geo1.compareTo(geo));
			 
			 ///Test if geo and geo1 are equal
			 if (geo.equals(geo1)==true)
				 System.out.println("True");
			 else
				 System.out.println("False");
			 
			 ///Test other and toDateString
			 geo1.GeoCountDownTimer(geo);
			 System.out.println(geo1.toDateString());
			 
			 ///Test the toString method
			 geo1.toString();
			 System.out.println(geo1);
			 
			///Test if geo and geo1 are equal
			 if (geo.equals(geo1)==true)
				 System.out.println("True");
			 else
				 System.out.println("False");
			 
			 ///Test all inc and dec methods
			 geo.dec();
			 System.out.println(geo);
			 geo.dec(4);
			 System.out.println(geo);
			 geo.inc();
			 System.out.println(geo);
			 geo.inc(4);
			 System.out.println(geo);			 
			 
			 ///Test daysToGo method
			 GeoCountDownTimer s1 = new GeoCountDownTimer (2,9,2015);
				System.out.println (s1.daysToGo("2/1/2015"));
				
				
			GeoCountDownTimer test = new GeoCountDownTimer(5,10,2015);
			System.out.println(test);
				
			test.inc(365);
			System.out.println(test);
			
		

			//test.inc();
			//System.out.println(test);
			
			try{
			GeoCountDownTimer empty = new GeoCountDownTimer("");
			}catch(IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
						
			//s1 equals 2/9/2015
			s1.save("testing");
			
			s1 = new GeoCountDownTimer("3/9/2017");

			//extra test to bottom
			GeoCountDownTimer s3 = new GeoCountDownTimer("3/3/2017");
			System.out.println(s3);
			
			s1.load("testing");
			System.out.println(s1);

			GeoCountDownTimer testDaysfut = new GeoCountDownTimer("6/20/2015");
			GeoCountDownTimer testDayscur = new GeoCountDownTimer("6/1/2015");

			System.out.println(testDayscur.daysToGo(testDaysfut.toDateString()));
			
			testDaysfut.save("future.txt");
			
			GeoCountDownTimer loadTest = new GeoCountDownTimer("04/08/2016");
					
			System.out.println("Test: " );
			
			testDaysfut.inc(5);
			
			System.out.println(testDaysfut.toDateString());
			
			testDaysfut.load("future.txt");

			
			//s3.load("testing");
				
			//s3.toDateString();
			//s3.toString();
				
				

			 

		   }
		 	
		 	
		 	
		 	
			
			
			

		
		 
	
}
