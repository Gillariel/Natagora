<?php
namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * Forum Entity
 *
 * @property int $ID
 * @property int $Likes
 * @property int $Dislike
 * @property int $Session_ID
 *
 * @property \App\Model\Entity\Tag[] $tag
 */
class Forum extends Entity
{

    /**
     * Fields that can be mass assigned using newEntity() or patchEntity().
     *
     * Note that when '*' is set to true, this allows all unspecified fields to
     * be mass assigned. For security purposes, it is advised to set '*' to false
     * (or remove it), and explicitly make individual fields accessible as needed.
     *
     * @var array
     */
    protected $_accessible = [
        'Likes' => true,
        'Dislike' => true,
        'Session_ID' => true,
        'tag' => true
    ];
}
