package granada;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

class outputRedmineHtml {
	public static void main(String args[]) {	
		
		// Initialize workers personal list.
		int workersNum = 3;
		workersList[] redmineData = new workersList[workersNum];
		for (int i=0; i<workersNum; i++ ) {
			redmineData[i] = new workersList();
		}
		// Test data
		redmineData[0].setName("Test");
		redmineData[0].setLevel(25);
		redmineData[0].setCurrentExp(30);
		redmineData[0].setNextExp(40);
		redmineData[1].setName("Test");
		redmineData[1].setLevel(2);
		redmineData[1].setCurrentExp(6);
		redmineData[1].setNextExp(7);
		redmineData[2].setName("Test");
		redmineData[2].setLevel(255);
		redmineData[2].setCurrentExp(20);
		redmineData[2].setNextExp(150);
		redmineData[2].setLevelUpFlag();
		
		try {
			File file = new File("redmine.html");

			if (checkBeforeWritefile(file)) {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

				// Start outputting HTML.
				pw.println("<html>");
				pw.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"ja\">");
				pw.println(" <head>");
				pw.println("<title>REDMINE EXPERIENCE LIST</title>");
				pw.println("<link rel=\"stylesheet\" href=\"./redmine.css\" type=\"text/css\" />");
				pw.println("<link rel=\"stylesheet\" href=\"chart.css\">");
				pw.println("<script src=\"https://code.createjs.com/createjs-2015.11.26.min.js\"></script>");
				pw.println("<script src=\"https://cdn.rawgit.com/ics-creative/ParticleJS/release/0.1.2/libs/particlejs.min.js\"></script>");
				pw.println("<script src=\"effect.js\"></script>");
				pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=Shift_JIS\">");
				pw.println("</head>");
				pw.println(" <body>");
				pw.println("<h1>REDMINE EXPERIENCE LIST</h1>");
				pw.println("<table class=\"type12\">");
				pw.println("<thead>");
				pw.println("<tr>");
				pw.println("<th scope=\"cols\" class=\"col01\">Workers</th>");
				pw.println("<th scope=\"cols\" class=\"col02\">Level</th>");
				pw.println("<th scope=\"cols\" class=\"col03\">Next Level</th>");
				pw.println("</tr>");
				pw.println("</thead>");
				pw.println("<tbody>");

				// Output workers personal data.
				for ( workersList worker : redmineData) {
				pw.println("<tr>");
				System.out.println(worker.getName());
				pw.println("<td class=\"col01\">" + worker.getName() + "</th>");
				System.out.println(worker.getLevel());
				if (worker.getLevelUpFlag()){
					pw.println("<td class=\"col04\">Lv." + worker.getLevel() + "</th>");
				}else {
					pw.println("<td class=\"col02\">Lv." + worker.getLevel() + "</th>");
				}
				pw.println("<td class=\"col03\">");
				pw.println("<div class=\"charts\">");
				pw.println("<div class=\"charts__chart chart--p100 chart--xl chart--default\">");
				pw.println("	<div class=\"charts__chart chart--p" + worker.getExpRate() + " chart--xl chart--green\" data-percent></div>");
				pw.println("</div>");
				pw.println("</div>");
				pw.println("</th>");
				pw.println("</tr>");
				if (worker.getLevelUpFlag()){
					pw.println("<canvas class=\"effect\" width=\"1400\" height=\"1040\" id=\"myCanvas\"></canvas>");
					}
				}
				
				pw.println("</tbody>");
				pw.println("</table>");

				pw.println("<hr />");
				pw.println("<footer>");
				pw.println("</footer>");
				pw.println("</body>");
				pw.println("</html>");

				// Outputting HTML finished.
				pw.close();

				System.out.println("Output finished.");
			} else {
				System.out.println("Can not write file.");
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	// Check whether exists redmine.html. If it does not exists, create it.
	private static boolean checkBeforeWritefile(File file) {
		if (file.exists()) {
			System.out.println("file exists.");
			if (file.isFile() && file.canWrite()) {
				System.out.println("file can Write");
				return true;
			}
		} else {
			System.out.println("file not exists.");
			try {
				System.out.println("create redmine.html.");
				file.createNewFile();
				return true;
			} catch (IOException e) {
				System.err.println(e);
				System.err.println("can not create redmine.html");
				return false;
			}
		}
		return false;
	}
	
}

// Define workers personal list.
class workersList { 
	private String name;
	private int level;
	private int currentExp;
	private int nextExp;
	private boolean levelUpFlag;
	
	workersList() {
		name = "";
		level = 0;
		currentExp = 0;
		nextExp = 1;
		levelUpFlag = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getExpRate() {
		return (int)(((double)this.currentExp/(double)this.nextExp)*100);
	}
	
	public boolean getLevelUpFlag() {
		return this.levelUpFlag;
	}
	
	public void setName(String name) {
		this.name = name;
		return;
	}
	
	public void setLevel(int level) {
		this.level = level;
		return;
	}
	
	public void setCurrentExp(int currentExp) {
		this.currentExp = currentExp;
		return;
	}
	
	public void setNextExp(int nextExp) {
		this.nextExp = nextExp;
		return;
	}
	
	public void setLevelUpFlag() {
		this.levelUpFlag = true; 
		return;
	}
	
	
	
}
