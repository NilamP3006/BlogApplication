package blogspot.demo.swagger.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blogspot.demo.swagger.domain.Blog;
import blogspot.demo.swagger.domain.BlogEntry;
import blogspot.demo.swagger.exceptions.NotFoundException;
import blogspot.demo.swagger.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	private static DecimalFormat df = new DecimalFormat(".#######");

	@Override
	public Blog create(Blog blogDTO) {

		int dpl = 1;
		String newFP = "";
		// String strtest = "";
		String str1 = "";
		String newDP = "";

		//

		if (blogDTO.getDisplayFormat().equals("Percentage")) {
			double decValue = blogDTO.getRawPrice() * 100;
			df.setRoundingMode(RoundingMode.DOWN);
			System.out.println("\n\n\n  decValue----------------->" + df.format(decValue));

			// double input1=23445.781271;
			String str[] = Double.toString(decValue).split("\\.");
			int length = str[1].length();

			System.out.println("Decimal Number :" + decValue);
			System.out.println("Integer Part:" + str[0]);
			System.out.println("Fractional Part :" + str[1]);

			char[] chars = str[1].toCharArray();

			int countdp = blogDTO.getDpl();
			int countfp = blogDTO.getFpl();
			char arr[] = new char[10];

			char arrFP[] = new char[10];

			for (int i = 0; i < countdp; i++) {
				// char c = str1.charAt(2);
				// System.out.println(c);
				char chars11 = str[1].charAt(i);
				System.out.print("chars11" + chars11);
				System.out.print("-->>" + str[1].charAt(i));

				//
				for (int j = 0; j < countdp; j++) {
					arr[i] = str[1].charAt(i);
				}

				newDP = String.valueOf(arr);
				System.out.println("newDP  :: " + newDP);
				//
				// char c = str1.charAt(2);
				System.out.println(str[1].substring(0, countdp));// he

			}

			// for (int j = countdp-1; j >countfp; j--) {

			for (int j = countdp; j < countdp + countfp; j++) {
				arrFP[j] = str[1].charAt(j);
			}

			newFP = String.valueOf(arrFP);
			System.out.println("newFP  :: " + newFP);
			//
			// char c = str1.charAt(2);

		}

		newDP = newDP.replace("\u0000", ""); //
		newFP = newFP.replace("\u0000", ""); //
		blogDTO.setDP(newDP);
		blogDTO.setFP(newFP);

		// Blog blog = new Blog(blogDTO.getName());
		// String name,String displayFormat,int scale,int dpl,int fpl,int decimal, int
		// rawPrice
		// Blog blog = new Blog(blogDTO.getName());
		Blog blog = new Blog(blogDTO.getName(), blogDTO.getDisplayFormat(), blogDTO.getScale(), blogDTO.getDpl(),
				blogDTO.getFpl(), blogDTO.getDecimal(), blogDTO.getRawPrice(), blogDTO.getDP(), blogDTO.getFP());
		return blogRepository.save(blog);
	}

	@Override
	public Blog udpateBlog(Blog blogDTO) {

		Blog existingBlog = requireNotNull(blogRepository.findOne(blogDTO.getId()), blogDTO.getId());

		existingBlog.setName(blogDTO.getName());

		return blogRepository.save(existingBlog);

	}

	private static Blog requireNotNull(Blog s, Integer blogId) {
		if (s == null)
			throw new NotFoundException("Blog with Id " + blogId + " not found!");
		else
			return s;
	}

	@Override
	public Blog updateBlogEntry(Blog blog, Collection<BlogEntry> blogEntry) {

		// maybe some error hanling, etc?
		blog.setBlogEntry(blogEntry);

		return blogRepository.save(blog);
	}

}
