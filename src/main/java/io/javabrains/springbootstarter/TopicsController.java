package io.javabrains.springbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicsController
{
   @Autowired
   private TopicService topicService;

   @RequestMapping("/topics")
   public List<Topic> getStrig()
   {
      return topicService.getTopics();
   }

   @RequestMapping("/topics/{id}")
   public Topic getTopic(@PathVariable String id)
   {
      return topicService.getTopic(id);
   }

   @RequestMapping(method = RequestMethod.POST, value = "/topics")
   public void putTopic(@RequestBody Topic topic)
   {
      topicService.addTopic(topic);
   }

   @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
   public void updateTopic(@RequestBody Topic topic, String id)
   {
      topicService.updateTopic(topic, id);
   }

   @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
   public void deleteTopic(@PathVariable String id)
   {
      topicService.delTopic(id);
   }
}
