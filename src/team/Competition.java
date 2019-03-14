package team;

import animals.Animal;
import course.Course;

public class Competition {

    private Animal[] teammates;
    private Course[] courses;

    public Competition(Animal[] teammates, Course[] courses) {

    }

    public void start() {
        for (Animal teammate : teammates) {

            for (Course cours : courses) {
                teammate.setOnDistance(cours.doIt(teammate));

                System.out.println(teammate.onDistance());


            }
        }
    }




}
