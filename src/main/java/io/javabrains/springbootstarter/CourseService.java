package io.javabrains.springbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService
{
   @Autowired
   private CourseRepository courseRepository;
   /*private List<Course> topics = new ArrayList<>(Arrays.asList(
         new Course("Spring", "Spring FrameWork", "Spring Description"),
         new Course("Java", "Spring FrameWork", "Spring Description"),
         new Course("Javascript", "Spring FrameWork", "Spring Description")
   ));*/

   public List<Course> getCourses(String topicId)
   {
      //return courses;
      List<Course> courses = new ArrayList<>();
      courseRepository.findByTopicId(topicId).forEach(courses::add);
      return courses;
   }

   public Course getCourse(String id)
   {
      //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
      return courseRepository.findById(id).get();
   }

   public void addCourse(Course course)
   {
      //topics.add(course);
      courseRepository.save(course);
   }

   public void updateCourse(Course course)
   {
      /*for (int i = 0; i < topics.size(); i++)
      {
         if (id.equals(topics.get(i).getId()))
         {
            topics.set(i, course);
         }
      }*/
      //save does both update and add
      courseRepository.save(course);
   }

   public void delCourse(String id)
   {
      //topics.removeIf(t -> t.getId().equals(id));
      courseRepository.deleteById(id);
   }
}
