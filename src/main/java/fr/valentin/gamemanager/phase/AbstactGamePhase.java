package fr.valentin.gamemanager.phase;

import fr.valentin.gamemanager.game.AbstractGame;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

/**
 * @author Val'entin.
 */
public abstract class AbstactGamePhase{

    private AbstractGame game;
    private String name;
    private String displayName;
    private int minute;
    private int seconde;

    private int runtime = 0;

    private BukkitTask bukkitTask;

    public AbstactGamePhase(AbstractGame game, String name, String displayName, int minute, int seconde){
        this.game = game;
        this.name = name;
        this.displayName = displayName;
        this.minute = minute;
        this.seconde = seconde;
    }

    public AbstractGame getGame() {
        return game;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getMinute() {
        return minute;
    }

    public int getSeconde() {
        return seconde;
    }

    public int getTotalTime(){
        return 60 * getMinute() + 1 * getSeconde();
    }

    public int getRuntime(){
        return runtime;
    }

    public void start(){

        onPhaseBegin();

        bukkitTask = new BukkitRunnable() {
            private long timer = getTotalTime();
            public void run() {
                runtime++;
                if (timer > 0){
                    onPhase();
                }
                else{
                    cancel();
                    onPhaseEnd();
                }
                timer--;
            }
        }.runTaskTimer(game.getPlugin(), 0, 1L * getTotalTime());

    }

    public void forceEndPhase(){
        bukkitTask.cancel();
        onPhaseEnd();
    }


    protected abstract void onPhaseBegin();

    protected abstract void onPhase();

    protected abstract void onPhaseEnd();
}
