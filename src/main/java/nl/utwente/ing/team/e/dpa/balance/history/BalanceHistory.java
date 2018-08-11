package nl.utwente.ing.team.e.dpa.balance.history;

import java.sql.Timestamp;

/**
 * @author Martijn Noorlander
 * @since 11-8-2018.
 */
public class BalanceHistory {

    private double open;

    private double close;

    private double high;

    private double low;

    private double volume;

    private Timestamp timestamp;

    public BalanceHistory() {
    }

    public BalanceHistory(double open, double close, double high, double low, double volume, Timestamp timestamp) {
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.timestamp = timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getOpen() {
        return open;
    }

    public double getClose() {
        return close;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getVolume() {
        return volume;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
