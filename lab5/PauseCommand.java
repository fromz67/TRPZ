public class PauseCommand implements Command {

    private final AudioEngine engine;

    public PauseCommand(AudioEngine engine) {
        this.engine = engine;
    }

    @Override
    public void execute() {
        System.out.println("Команда: поставити на паузу");
        engine.pause();
    }
}

