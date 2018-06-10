package P3;

import java.util.List;

public interface ProductDAO {
	public List<Product> findAll();
	public List<Product> findByOVChipkaart(OVChipkaart ovchipkaart);
	public List<Ov_chipkaart_product> findByPK(OVChipkaart ovchipkaart);
	public Product save(Product product);
	public Product update(Product product);
	public boolean delete(Product product);
}