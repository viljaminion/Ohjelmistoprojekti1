package ohjelmistoprojekti.ticketGuru.Controllers;

@Controller
public class SellerController {

    @Autowired
    private SellerRepository sellerrepository;

    @RequestMapping("/sellerlist")
    public String sellerList(Model model) {
        model.addAttribute("sellers", sellerRepository.findAll());
        return "sellerlist";
    }

    @GetMapping("/sellers/add")
    public String addSeller(Model model) {
        model.addAttribute("seller", new Seller());
        //model.addAttribute("transactions", transactionRepository.findAll());
        return "addSeller";
    }

    @PostMapping("/sellers/save")
    public String saveSeller(@ModelAttribute Seller seller, Model model) {
        sellerRepository.save(seller);
        return "redirect:/sellerlist";
    }

    @GetMapping("/editSeller/{id}")
	public String editSeller(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editSeller", SellerRepository.findById(id));
		return "editBook"; 
	}

    @GetMapping("/sellers/delete/{id}")
    public String deleteSeller(@PathVariable Long sellerid) {
        sellerRepository.deleteById(sellerid);
        return "redirect:/sellerlist";
    }

}