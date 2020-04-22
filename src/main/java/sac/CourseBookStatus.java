package sac;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CourseBookStatus_table")
public class CourseBookStatus {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long ticketBookId;
        private String bookStatus;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getTicketBookId() {
            return ticketBookId;
        }

        public void setTicketBookId(Long ticketBookId) {
            this.ticketBookId = ticketBookId;
        }
        public String getBookStatus() {
            return bookStatus;
        }

        public void setBookStatus(String bookStatus) {
            this.bookStatus = bookStatus;
        }

}
