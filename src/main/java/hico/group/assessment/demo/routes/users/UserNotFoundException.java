package hico.group.assessment.demo.routes.users;

public class UserNotFoundException extends RuntimeException {
    UserNotFoundException(Long id) {
        super(String.format("User with ID %d could not be found.", id));
    }
}
