<?php
namespace App\Model\Entity;

use Cake\ORM\Entity;

/**
 * Top5Bird Entity
 *
 * @property string $Name
 * @property int $Number
 */
class Top5Bird extends Entity
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
        'Name' => true,
        'Number' => true
    ];
}
