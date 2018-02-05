
//global variables to store academic and attendance values;
//in academic perspective, based on marks students are categorized into 4 grades types.(A,B,C and Fail)
//in attendance perspective, based in attendance students are  categorized into 4 grades.(A,B,C,D,E)  

var total_students=0;

var academic_A_Grade=0;
var academic_B_Grade=0;
var academic_C_Grade=0;
var academic_Fail_Grade=0;

var attendence_A_Grade=0;
var attendence_B_Grade=0;
var attendence_C_Grade=0;
var attendence_D_Grade=0;
var attendence_E_Grade=0;
window.onload = function () {
	getValues();
	//studentAcademicChart();
	//studentAttendenceChart();
}



function studentAcademicChart() {
	//total_students=5;
var options = {
	title: {
		text: "Student Academic Report"
	},
	subtitles: [{
		text: "present year"
	}],
	animationEnabled: true,
	data: [{
		type: "bar",
		startAngle: 40,
		toolTipContent: "<b>{label}</b>: {y}%",
		showInLegend: "true",
		legendText: "{label}",
		indexLabelFontSize: 16,
		indexLabel: "{label} - {y}%",
		dataPoints: [
			{ y: (academic_A_Grade/total_students)*100, label: "'A' Grade(500-600)" },
			{ y: (academic_B_Grade/total_students)*100, label: "'B' Grade(450-500)" },
			{ y: (academic_C_Grade/total_students)*100, label: "'C' Grade(360-450)" },
			{ y: (academic_Fail_Grade/total_students)*100, label: "Fail(Below 360)" }
		]
	}]
};
$("#chartContainer_academicReport").CanvasJSChart(options);

}


function studentAttendenceChart() {
var options = {
	title: {
		text: "Student Attendence Report"
	},
	subtitles: [{
		text: "present year"
	}],
	animationEnabled: true,
	data: [{
		type: "pie",
		startAngle: 30,
		toolTipContent: "<b>{label}</b>: {y}%",
		showInLegend: "true",
		legendText: "{label}",
		indexLabelFontSize: 16,
		indexLabel: "{label} - {y}%",
		dataPoints: [
			{ y: (attendence_A_Grade/total_students)*100, label: "(90-100)%" },
			{ y: (attendence_B_Grade/total_students)*100, label: "(80-90)%" },
			{ y: (attendence_C_Grade/total_students)*100, label: "(70-80)%" },
			{ y: (attendence_D_Grade/total_students)*100, label: "(50-60)" },
			{ y: (attendence_E_Grade/total_students)*100, label: "(50 Below)" }
		]
	}]
};
$("#chartContainer_attendenceReport").CanvasJSChart(options);
}

function getValues() {
	
	$.ajax({
		url : contextPath + '/student',
		type : 'GET',
		success : function(result, status) {
			total_students=result.length;
			setAcademicValues(result);
			setAttendenceValues(result);
		
			studentAcademicChart();
			studentAttendenceChart();
		},
		error : function(result, status) {
			alert("Error occured : " + status);
		}
	});
	
}

function setAcademicValues(studentList) {
    for(var i=0;i<studentList.length;i++) {
    	if(studentList[i].marks>=500 && studentList[i].marks<=600) 
    		academic_A_Grade++;
    	else if(studentList[i].marks>=450 && studentList[i].marks<500)
    		academic_B_Grade++;
    	else if(studentList[i].marks>=360 && studentList[i].marks<450)
    		academic_C_Grade++;
    	else
    		academic_Fail_Grade++;
    }
}

function setAttendenceValues(studentList) {
	 for(var i=0;i<studentList.length;i++) {
	    	
		 if(studentList[i].attendence>=90 && studentList[i].attendance<=100)
			 attendence_A_Grade++;
		 else if(studentList[i].attendence>=80 && studentList[i].attendance<90)
			 attendence_B_Grade++;
		 else if(studentList[i].attendence>=70 && studentList[i].attendance<80)
			 attendence_C_Grade++;
		 else if(studentList[i].attendence>=50 && studentList[i].attendance<70)
			 attendence_D_Grade++;
		 else
			 attendence_D_Grade++;		 
      }
}


