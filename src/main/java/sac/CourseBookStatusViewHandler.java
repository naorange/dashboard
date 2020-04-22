package sac;

import sac.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CourseBookStatusViewHandler {


    @Autowired
    private CourseBookStatusRepository courseBookStatusRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenTicketBooked_then_CREATE_1 (@Payload TicketBooked ticketBooked) {
        try {
            if (ticketBooked.isMe()) {
                // view 객체 생성
                CourseBookStatus courseBookStatus = new CourseBookStatus();
                // view 객체에 이벤트의 Value 를 set 함
                courseBookStatus.setTicketBookId(ticketBooked.getId);
                // view 레파지 토리에 save
                courseBookStatusRepository.save(courseBookStatus);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @StreamListener(KafkaProcessor.INPUT)
    public void whenTicketCanceled_then_DELETE_1(@Payload TicketCanceled ticketCanceled) {
        try {
            if (ticketCanceled.isMe()) {
                // view 레파지 토리에 삭제 쿼리
                courseBookStatusRepository.deleteByTicketBookId(ticketCanceled.getId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}