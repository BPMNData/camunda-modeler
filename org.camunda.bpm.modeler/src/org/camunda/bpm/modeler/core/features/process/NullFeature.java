package org.camunda.bpm.modeler.core.features.process;

import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IRemoveContext;

/**
 * This feature does absolutely nothing. It can be applied to express that an
 * object is not capable of certain features.
 */
public class NullFeature implements IDeleteFeature, IRemoveFeature, IMoveShapeFeature {

  @Override
  public boolean isAvailable(IContext context) {
    return false;
  }

  @Override
  public boolean canExecute(IContext context) {
    return false;
  }

  @Override
  public void execute(IContext context) {
  }

  @Override
  public boolean canUndo(IContext context) {
    return false;
  }

  @Override
  public boolean hasDoneChanges() {
    return false;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public String getDescription() {
    return null;
  }

  @Override
  public IFeatureProvider getFeatureProvider() {
    return null;
  }

  @Override
  public boolean canDelete(IDeleteContext context) {
    return false;
  }

  @Override
  public void preDelete(IDeleteContext context) {

  }

  @Override
  public void delete(IDeleteContext context) {
  }

  @Override
  public void postDelete(IDeleteContext context) {
  }

  @Override
  public boolean canRemove(IRemoveContext context) {
    return false;
  }

  @Override
  public void preRemove(IRemoveContext context) {
  }

  @Override
  public void remove(IRemoveContext context) {
  }

  @Override
  public void postRemove(IRemoveContext context) {
  }

  @Override
  public boolean canMoveShape(IMoveShapeContext context) {
    return false;
  }

  @Override
  public void moveShape(IMoveShapeContext context) {
  }

}
