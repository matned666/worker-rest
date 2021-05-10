package eu.mrndesign.matned.workerrest.workerrestapplication.model;

public interface IEntity<Entity1, Entity2> {

    void addToList(Entity2 added);
    void removeFromList(Entity2 added);
}
