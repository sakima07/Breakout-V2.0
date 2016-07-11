package Breakout.control;

import Breakout.BallFactory;
import Breakout.Breakout;
import com.almasb.ents.AbstractControl;
import com.almasb.ents.Entity;
import com.almasb.fxgl.entity.component.PositionComponent;
import com.almasb.fxgl.physics.PhysicsComponent;
import javafx.geometry.Point2D;

/**
 * Created by Romano on 09.07.2016.
 */
public class BallControl extends AbstractControl {

    public static PositionComponent position;
    public static PhysicsComponent ball;

    @Override
    public void onAdded(Entity entity) {

        ball = entity.getComponentUnsafe(PhysicsComponent.class);
        position = entity.getComponentUnsafe(PositionComponent.class);
    }

    @Override
    public void onUpdate(Entity entity, double tpf) {

        /*Point2D v = ball.getLinearVelocity();
        if (Math.abs(v.getY()) < 2) {
            double x = v.getX();
            double signY = Math.signum(v.getY());
            ball.setLinearVelocity(x, signY * 5);
        }
        if (Math.abs(v.getX()) < 2){

            ball.setLinearVelocity(Math.signum(v.getX()) * 5,
                        v.getY());

        }
        if (Math.abs(v.getX()) >= 20 || Math.abs(v.getY()) >= 20 ){

            ball.setLinearVelocity(Math.signum(v.getX()) * 20, Math.signum(v.getY() * 20));

        }*/
    }

    public void speedUpBall(){

        if(ball != null){
            Point2D v = ball.getLinearVelocity();
            if (Math.abs(v.getY()) <= 15 && Math.abs(v.getX()) <= 15){
                ball.setLinearVelocity(Math.signum(v.getX()) * 15,
                        Math.signum(v.getY()) * 15);
            }
        }

    }

    public void slowDownBall(){

        if(ball != null){
            Point2D v = ball.getLinearVelocity();
            if (Math.abs(v.getY()) >= 5 && Math.abs(v.getX()) >= 5){
                ball.setLinearVelocity(Math.signum(ball.getLinearVelocity().getX()) * 2,
                        Math.signum(ball.getLinearVelocity().getY()) * 2);
            }

        }
    }

    public void multiBall(){

        if(ball != null){

            Point2D p = position.getValue();
            BallFactory bf = new BallFactory();
            Breakout.gameWorld.addEntities(bf.createMultiball(p, 1, "green"));

        }


    }
}
