package demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

//import org.springframework.web.bind.annotation.*

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@RestController
class MessageResource(val service: MessageService) {
    @GetMapping
    fun index(): List<Message> = service.findMessages()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun post(@RequestBody message: Message): String {
        service.post(message)
        return "Created"
    }
}

@Table("MESSAGES")
data class Message(@Id val id: String?, val text: String)

@Service
class MessageService(val db:MessageRepository) {
    fun findMessages(): List<Message> = db.findMessages()

    fun post(message: Message) {
        db.save(message)
    }
}

interface MessageRepository : CrudRepository<Message, String> {
    @Query("select * from messages")
    fun findMessages(): List<Message>
}