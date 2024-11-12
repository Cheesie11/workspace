package ch.zli.m223.model;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Entry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime checkIn;

  @Column(nullable = false)
  private LocalDateTime checkOut;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @ManyToMany
  @JoinTable(
    name = "entry_tag",
    joinColumns = @JoinColumn(name = "entry_id"),
    inverseJoinColumns = @JoinColumn(name = "tag_id")
  )
  private List<Tag> tags;

  // Getter und Setter für category und tags
  public Category getCategory() {
      return category;
  }

  public void setCategory(Category category) {
      this.category = category;
  }

  public List<Tag> getTags() {
      return tags;
  }

  public void setTags(List<Tag> tags) {
      this.tags = tags;
  }

  public void setCheckIn(LocalDateTime minusHours) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setCheckIn'");
  }

public void setCheckOut(LocalDateTime now) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setCheckOut'");
}
}