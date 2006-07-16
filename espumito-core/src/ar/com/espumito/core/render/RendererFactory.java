package ar.com.espumito.core.render;

public interface RendererFactory {

	public Renderer getRenderer(String id);

	public void addRenderer(String id, Renderer renderer);

}