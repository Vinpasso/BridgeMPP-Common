package bridgempp.log;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import bridgempp.state.Event;
import bridgempp.state.EventManager;

class LogHandler extends Handler {

    public LogHandler() {
    }

    @Override
    public void publish(LogRecord record) {
    	EventManager.fireEvent(Event.LOG, record);
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() throws SecurityException {
    }
}