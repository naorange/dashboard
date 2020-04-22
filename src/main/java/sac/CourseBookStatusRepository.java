package sac;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseBookStatusRepository extends CrudRepository<CourseBookStatus, Long> {


        void deleteByTicketBookId(Long ticketBookId);
}