import org.improving.tag.commands.JumpCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JumpCommandTests {
    JumpCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {
        // Arrange
        io = new TestInputOutput();
        target = new JumpCommand(io);
    }

    // TESTING EXECUTE
    @Test
    public void execute_should_return_phrase() {
        // Act
        target.execute(null, null);

        // Assert
        assertEquals("You jumped around like a mad man.", io.lastText);
    }

    // TESTING INPUT
    @Test
    public void isValid_should_be_true_when_input_is_jump() {
        // Act
        var result = target.isValid("jump", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_jump_with_spaces() {
        // Act
        var result = target.isValid("     jump         ", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_jump_with_caps() {
        // Act
        var result = target.isValid("JUMp", null);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar() {
        // Act
        var result = target.isValid("foobar", null);

        // Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_null() {
        // Act
        var result = target.isValid(null, null);

        // Assert
        assertFalse(result);
    }
}
