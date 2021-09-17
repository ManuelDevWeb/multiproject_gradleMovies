package co.com.cloud.movies.servicebooking.services;

public class BookinServiceImpl {
    private final BookingRepository bookingRepository;
    private final UserClient userClient;

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking findByNumberBooking(String numberBooking) {
        Booking booking = bookingRepository.findByNumberBooking(numberBooking);
        ModelMapper modelMapper = new ModelMapper();
        User user  = modelMapper.map(userClient.findById(booking.getUserId()).getData(),User.class);
        //Customer customer  = (Customer)customerClient.findById(invoice.getCustomerId()).getData();
        booking.setUser(user);
        List<BookingItem> itemList = booking.getItems().stream()
                .map( bookingItem -> {
                    Movie movie = modelMapper.map(movieClient.findById(bookingItem.getMovieId()).getData(),Movie.class);
                    //Product product = (Product)productClient.findById(invoiceItem.getProductId()).getData();
                    bookingItem.setMovie(movie);
                    return bookingItem;
                }).collect(Collectors.toList());
        return bookingRepository.findByNumberBooking(numberBooking);
    }
}
