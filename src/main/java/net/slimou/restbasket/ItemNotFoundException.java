package net.slimou.restbasket;

class ItemNotFoundException extends RuntimeException {
    ItemNotFoundException(Integer id) {
        super("Could not find item " + id);
    }
}
