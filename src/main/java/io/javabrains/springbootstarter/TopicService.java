package io.javabrains.springbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService
{
   @Autowired
   private TopicRepository topicRepository;
   /*private List<Course> topics = new ArrayList<>(Arrays.asList(
         new Course("Spring", "Spring FrameWork", "Spring Description"),
         new Course("Java", "Spring FrameWork", "Spring Description"),
         new Course("Javascript", "Spring FrameWork", "Spring Description")
   ));*/

   public List<Topic> getTopics()
   {
      //return topics;
      List<Topic> topics = new ArrayList<>();
      topicRepository.findAll().forEach(topics::add);
      return topics;
   }

   public Topic getTopic(String id)
   {
      //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
      return topicRepository.findById(id).get();
   }

   public void addTopic(Topic topic)
   {
      //topics.add(topic);
      topicRepository.save(topic);
   }

   public void updateTopic(Topic topic, String id)
   {
      /*for (int i = 0; i < topics.size(); i++)
      {
         if (id.equals(topics.get(i).getId()))
         {
            topics.set(i, topic);
         }
      }*/
      //save does both update and add
      topicRepository.save(topic);
   }

   public void delTopic(String id)
   {
      //topics.removeIf(t -> t.getId().equals(id));
      topicRepository.deleteById(id);
   }
}
